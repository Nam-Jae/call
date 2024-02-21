<template>

    <v-data-table
        :headers="headers"
        :items="center"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'CenterView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "carId", value: "carId" },
                { text: "driverName", value: "driverName" },
                { text: "workerId", value: "workerId" },
                { text: "position", value: "position" },
                { text: "hospitalId", value: "hospitalId" },
                { text: "address", value: "address" },
                { text: "accidentTime", value: "accidentTime" },
                { text: "dispatchTime", value: "dispatchTime" },
            ],
            center : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/centers'))

            temp.data._embedded.centers.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.center = temp.data._embedded.centers;
        },
        methods: {
        }
    }
</script>

