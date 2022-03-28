const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({

  configureWebpack: {
    devServer: {
      historyApiFallback: true
    }
  },

  transpileDependencies: true,
  publicPath: '',

  pluginOptions: {
    vuetify: {
			// https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
		}
  }
})
