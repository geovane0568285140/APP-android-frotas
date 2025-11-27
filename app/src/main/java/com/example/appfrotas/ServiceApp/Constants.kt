package com.example.appfrotas.ServiceApp

class Constants private constructor() {


    object DateTime {

        const val dateTime = "dd-MM-yyyy HH:mm"

    }

    object SharedPreference {

        object file_user{

            const val file_name = "user_date"

            const val keyPassword = "key_password"
            const val keyUserName = "key_user_name"
            const val keyToken = "key_token"

            const val keyLocalDateTimeLastToken = "key_localDataTimeLastToken"
            const val keyLocalDateTimeLogin = "key_localDataTimeLogin"
        }

    }

    object Local {

        object dataBase {
            const val nameDataBase = "db.frota"

            object table {
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