<script setup>
import { reactive } from 'vue'
import { router } from '@inertiajs/vue3'

const form = reactive({
  firstNaame: null,
  lastName: null,
  email: null,
})

function submit() {
  router.post('/users', form)
}
</script>

<template>
  <form @submit.prevent="submit">
    <label for="first_name">First name:</label>
    <input id="first_name" v-model="form.firstName" />
    <label for="last_name">Last name:</label>
    <input id="last_name" v-model="form.lastName" />
    <label for="email">Email:</label>
    <input id="email" v-model="form.email" />
    <button type="submit">Submit</button>
  </form>
</template>