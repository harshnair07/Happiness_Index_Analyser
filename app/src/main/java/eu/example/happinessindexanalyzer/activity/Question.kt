package eu.example.happinessindexanalyzer.activity

data class Question(
    val id:Int,

    val question:String,
    val OptionOne:String,
    val OptionTwo:String,
    val OptionThree:String,
    val OptionFour:String,
    val CorrectAns:Int

)
