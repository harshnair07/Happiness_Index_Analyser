package eu.example.happinessindexanalyzer.activity

object constant {

const val USER_NAME : String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"


    fun getQuestions():ArrayList<Question>{
        val questionsList=ArrayList<Question>()

        val ques1 = Question(

            1,"Facilities includes all the basic needs for a student such as well maintained classroom, hygienic toilets , traveling facilities , availability of resources and many more." +
                    "Are you able to get the all basic requirements that you need and do u think that you are under good governance ." +
                    "Rate this parameter on a scale of 1-10",
            "New Delhi","Madhya Pradesh",
            "Uttar Pradesh ","Bihar",
            1
        )
        questionsList.add(ques1)

        val ques2 = Question(
            2,"The process of organizing and planning how to divide your time between different activities. One of the most difficult things in student life is time management." +
                    " Are you able to manage your workload with proper sleep cycle?" +
                    "Rate this parameter on a scale of 1-10",
            "Ostrich","Peacock",
            "Pigeon ","Sparrow",
            2
        )
        questionsList.add(ques2)

        val ques3 = Question(
            3,"The freedom for students to learn, explore, exercise your freedoms, seek information , decide what you believe & challenge ideas while building and sharing your own opinions is the foundation of what is called academic freedom." +
                    "So as a student do you think you get full academic freedom?" +
                    "Rate this parameter on a scale of 1-10",
            "Mango","Apple",
            "Banana ","Pomegranate",
            1
        )
        questionsList.add(ques3)

        val ques4 = Question(
            4,"What is the relationship between student and teacher? The relationship between student and teacher plays a large role in the trajectory of a child's academic success and social development." +
                    "Why are healthy parent-teacher relationships important? Positive connections between parents and teachers " +
                    "have been shown to improve children's academic achievement, social competencies and emotional well-being." +
                    "Rate this parameter on a scale of 1-10.",
            "New Delhi","Madhya Pradesh",
            "Uttar Pradesh ","Bihar",
            1
        )
        questionsList.add(ques4)

        val ques5 = Question(
            5,"Health is defined as the state of body physically and mentally sound. As the famous saying goes-“Health is Wealth”. Studies are the most important element of a student’s life but so is fitness and health. The physical and mental well being of a person plays an important role in the life of a person. The absence of disease in life makes man able to achieve desired aims and objectives." +
                    "Do you manage your health as well as studies at the same time?" +
                    "Rate this parameter on a scale of 1-10",
            "1","7",
            "5 ","10",
            2
        )
        questionsList.add(ques5)

        val ques6 = Question(
            6,"Why is gender equality? Gender equality prevents violence against women and girls. It's essential for economic prosperity. Societies that value women and men as equal are safer and healthier. Racial equality occurs when institutions give equal opportunities to people of all races. In other words, regardless of physical traits such as skin color, institutions are to give individuals legal, moral, and political equality." +
                    "Do you think your school gives equal opportunities to all races?" +
                    "Rate this parameter on a scale of 1-10",
            "Melbourne","Sydney",
            "Canberra ","Perth",
            3
        )
        questionsList.add(ques6)

        val ques7 = Question(
            7,"The physical environment of the school speaks to the contribution that safe, clean, and comfortable surroundings make to a positive school climate in which students can learn. The importance of positive surrounding in school is to provide a healthy and safe surrounding for students. There are many issues related to hygiene that students and school employees have to face every day. " +
                    "So do you think that you should get proper surrounding and sanitation in your school?" +
                    "Rate this parameter on a scale of 1-10",
            "Melbourne","Sydney",
            "Canberra ","Perth",
            3
        )
        questionsList.add(ques7)
        val ques8 = Question(
            8,"Bullying is linked to many negative outcomes including impacts on mental health, substance use, and depression. " +
                    "It is a very complex social phenomenon?" +
                    "Have you ever been bullied?" +
                    "Rate this parameter on a scale of 1-10",
            "New Delhi","Madhya Pradesh",
            "Canberra ","Perth",
            1
        )


        return questionsList
    }
}