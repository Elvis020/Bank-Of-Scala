object MyApplication{
  def main(args: Array[String]): Unit = {
    println("This is the entry point to the MyApplication Scala Object")
    args foreach(println)
  }
}

MyApplication.main(Array("Ok","Moi"))