<template>

    <v-card outlined>
        <v-card-title>
            Center # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="CarId" v-model="item.carId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DriverName" v-model="item.driverName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="WorkerId" v-model="item.workerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Position" v-model="item.position" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="HospitalId" v-model="item.hospitalId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Address" v-model="item.address" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AccidentTime" v-model="item.accidentTime" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DispatchTime" v-model="item.dispatchTime" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'CenterViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/centers/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

