package com.cead.androidquince.deserializer

import com.cead.androidquince.smodel.CityFind
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class CityFindDes : JsonDeserializer<CityFind> {


    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): CityFind ?{
        var id = json!!.asJsonObject.get("id").asInt
        var name = json!!.asJsonObject.get("name").asString
        var code = json!!.asJsonObject.get("cod").asInt
        var country = json!!.asJsonObject.get("sys").asJsonObject.get("country").asString

        return CityFind(id,name, code, country)
    }
}