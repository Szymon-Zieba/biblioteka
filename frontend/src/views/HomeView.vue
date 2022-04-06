<script>
import MainHeader from "@/components/MainHeader.vue";
import MainFooter from "@/components/MainFooter.vue";
export default {
  components: { MainHeader, MainFooter },
  name: "HomeView",
  setup() {
    return {};
  },
};
</script>

<template>
  <div id="container">
    <main-header />
    <div style="width: 100%; height: 6rem"></div>
    <div id="content" class="text-center">
      <span class="text-h1 font-weight-regular"
        >WITAJ W
        <span class="text-h1 font-weight-regular highlighted"
          >BIBLIOTECE ONLINE</span
        ></span
      >
      <span class="text-h3 mt-16 pb-2"
        >Przeglądaj i wypożyczaj książki
        <span class="text-h3 mt-16 highlighted">ONLINE</span></span
      >
    </div>

    <main-footer />
  </div>
</template>

<style scoped>
* {
  font-size: 20px;
  overflow: hidden;
}

#container {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  background-image: url("../../public/img/home-background-image.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  height: 100vh;
}

#content {
  width: 100%;
  color: white;
  display: flex;
  flex-direction: column;
}

.highlighted {
  color: burlywood;
}
</style>
