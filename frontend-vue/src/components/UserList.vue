<script setup>
const props = defineProps({
  userList: [],
});

const columns = [
  {
    name: "id",
    label: "id",
    field: "id",
    align: "left",
    sortable: true,
    sort: (a, b) => parseInt(a, 10) - parseInt(b, 10),
    required: true,
  },
  {
    name: "name",
    label: "name",
    field: "name",
    align: "center",
    sortable: true,
    required: true,
  },
  {
    name: "email",
    label: "email",
    field: "email",
    align: "center",
    sortable: true,
    required: true,
  },
  {
    name: "username",
    label: "username",
    field: "username",
    align: "username",
    sortable: true,
  },
  {
    name: "address",
    label: "address",
    field: "address",
    align: "address",
    sortable: true,
  },
  {
    name: "phone",
    label: "phone",
    field: "phone",
    align: "phone",
    sortable: true,
  },
  {
    name: "website",
    label: "website",
    field: "website",
    align: "website",
    sortable: true,
  },
  {
    name: "company",
    label: "company",
    field: "company",
    align: "company",
    sortable: true,
  },
];
</script>

<template>
  <div class="q-pa-md">
    <q-table
      class="my-sticky-header-table"
      title="UserList"
      :rows="userList"
      :columns="columns"
      row-key="name"
      flat
      bordered
    />
  </div>
</template>

<style lang="sass">
.my-sticky-header-table
  /* height or max-height is important */
  height: 500px

  .q-table__top,
  .q-table__bottom,
  thead tr:first-child th
    /* bg color is important for th; just specify one */
    background-color: #c1f4cd

  thead tr th
    position: sticky
    z-index: 1
  thead tr:first-child th
    top: 0

  /* this is when the loading indicator appears */
  &.q-table--loading thead tr:last-child th
    /* height of all previous header rows */
    top: 48px
</style>
