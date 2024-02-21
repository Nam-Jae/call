
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import EmergencyCallCallManager from "./components/listers/EmergencyCallCallCards"
import EmergencyCallCallDetail from "./components/listers/EmergencyCallCallDetail"

import DispatchDispatchManager from "./components/listers/DispatchDispatchCards"
import DispatchDispatchDetail from "./components/listers/DispatchDispatchDetail"

import HospitalHospitalManager from "./components/listers/HospitalHospitalCards"
import HospitalHospitalDetail from "./components/listers/HospitalHospitalDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/emergencyCalls/calls',
                name: 'EmergencyCallCallManager',
                component: EmergencyCallCallManager
            },
            {
                path: '/emergencyCalls/calls/:id',
                name: 'EmergencyCallCallDetail',
                component: EmergencyCallCallDetail
            },

            {
                path: '/dispatches/dispatches',
                name: 'DispatchDispatchManager',
                component: DispatchDispatchManager
            },
            {
                path: '/dispatches/dispatches/:id',
                name: 'DispatchDispatchDetail',
                component: DispatchDispatchDetail
            },

            {
                path: '/hospitals/hospitals',
                name: 'HospitalHospitalManager',
                component: HospitalHospitalManager
            },
            {
                path: '/hospitals/hospitals/:id',
                name: 'HospitalHospitalDetail',
                component: HospitalHospitalDetail
            },




    ]
})
