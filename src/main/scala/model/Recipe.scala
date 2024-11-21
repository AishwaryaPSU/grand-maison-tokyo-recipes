package model

case class Recipe(
                   id: Int,
                   title: String,
                   makingTime: String,
                   cost: String,
                   serves: String,
                   ingredients: List[String]
                 )
