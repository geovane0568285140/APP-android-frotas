package com.example.appfrotas

class Constants private constructor() {


    object DateTime{

        const val dateTime = "dd-MM-yyyy HH:mm"

    }


    object Local {

        object dataBase{
            const val nameDataBase = "db.frota"

            object table{
                const val userTable_name = "dbo.user"
                const val carFrotaTable_name = "dbo.car_frota"
                const val exitTable_name = "dbo.exit_record"
                const val arrivalTable_name = "dbo.arrival_record"
                const val supplyTable_name = "dbo.supply"
                const val observationTable_name = "dbo.observation"
                const val carRequestTable_name = "dbo.car_request"
            }
        }

    }

    object remote {

    }
}