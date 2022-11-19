<script>
    import Changer from "./lib/Changer.svelte";
    import bg from './assets/bg.jpg'
</script>

<main>
  <img src={bg} alt="" class="fixed left-0 top-0 w-full object-cover h-full -z-20">
  <Changer></Changer>
</main>

<style>
  /* .logo {
    height: 6em;
    padding: 1.5em;
    will-change: filter;
  }
  .logo:hover {
    filter: drop-shadow(0 0 2em #646cffaa);
  }
  .logo.svelte:hover {
    filter: drop-shadow(0 0 2em #ff3e00aa);
  }
  .read-the-docs {
    color: #888;
  } */
</style>
