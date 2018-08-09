/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.chikeandroid.pagingtutsplus.workers

import android.util.Log
import androidx.work.Worker
import com.chikeandroid.pagingtutsplus.data.AppDatabase
import com.chikeandroid.pagingtutsplus.data.Person
import com.chikeandroid.pagingtutsplus.utils.NAME_DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader

class SeedDatabaseWorker : Worker() {

    private val TAG = SeedDatabaseWorker::class.java.simpleName

    override fun doWork(): Worker.Result {
        val nameType = object : TypeToken<List<Person>>() {}.type
        var jsonReader: JsonReader? = null

        return try {
            val inputStream = getApplicationContext().assets.open(NAME_DATA_FILENAME)
            jsonReader = JsonReader(inputStream.reader())
            val nameList: List<Person> = Gson().fromJson(jsonReader, nameType)
            val database = AppDatabase.getInstance(applicationContext)
            database.personDao().insertAll(nameList)
            Worker.Result.SUCCESS
        } catch (ex: Exception) {
             Log.e(TAG, "Error seeding database", ex)
            Worker.Result.FAILURE
        } finally {
            jsonReader?.close()
        }
    }
}