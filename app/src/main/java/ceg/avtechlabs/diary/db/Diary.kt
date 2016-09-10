package ceg.avtechlabs.diary.db

import com.orm.SugarRecord

/**
 * Created by adhithyan-3592 on 17/08/16.
 */

class Diary: SugarRecord {
    var date: String? = null
    var entry: String? = null

    constructor() {}

    constructor(date: String, entry: String) {
        this.date = date
        this.entry = entry
    }

}