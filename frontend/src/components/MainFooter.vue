<script>
export default {
  name: "MainFooter",
  setup() {
    return {};
  },
};
</script>

<template>
  <v-footer class="footer text-center">
    <v-row class="footer-content">
      <v-col>
        <span class="font-weight-bold">Kontakt</span>
        <br />+48 644 322 123 <br />biblioteka@gmail.com <br />
        Rzeszów ul.Piłsudzkiego 13
      </v-col>

      <v-col>
        <span class="font-weight-bold">Biblioteki są otwarte w godzinach:</span>
        <v-row>
          <v-col align="right">
            Poniedziałek<br />
            Wtorek<br />
            Środa<br />
            Czwartek<br />
            Piątek
          </v-col>
          <v-col align="left">
            8:00 - 16:00<br />
            8:00 - 16:00<br />
            10:00 - 18:00<br />
            8:00 - 16:00<br />
            8:00 - 16:00
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </v-footer>
</template>

<style>
.footer {
  bottom: 0;
  width: 100%;
  background: burlywood;
  flex: inherit;
}

.footer-content {
  font-size: 0.7rem;
}
</style>
