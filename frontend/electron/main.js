const { app, BrowserWindow } = require("electron");
const path = require("path");
const isDev = require("electron-is-dev");

var child;
var mySQLChild;

function createWindow() {
  const win = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      preload: path.join(__dirname, "../electron/preload.js"),
    },
  });

  win.loadURL(
    isDev
      ? "http://localhost:8080"
      : `file://${path.join(__dirname, "../dist/index.html")}`
  );

  if (isDev) {
    win.webContents.openDevTools({ mode: "detach" });
  }
}

app.whenReady().then(() => {
  var mysqlPath = "../mysql/bin/mysqld.exe";
  mySQLChild = require("child_process").execFile(mysqlPath);

  var jarPath = app.getAppPath() + "\\electron\\GoRead-0.0.1-SNAPSHOT.jar";
  child = require("child_process").spawn("java", ["-jar", jarPath, ""]);

  createWindow();

  app.on("activate", () => {
    if (BrowserWindow.getAllWindows().length === 0) {
      createWindow();
    }
  });
});

app.on("window-all-closed", () => {
  if (process.platform !== "darwin") {
    console.log(child.pid, mySQLChild.pid);
    app.quit();
    var kill = require("tree-kill");
    kill(child.pid);
    kill(mySQLChild.pid);
  }
});
