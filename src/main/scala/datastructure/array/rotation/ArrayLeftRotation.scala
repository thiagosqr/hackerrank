package datastructure.array.rotation

object ArrayLeftRotation {

    def main(args: Array[String]): Unit = {

      val arr = Array(1,2,3,4)
      val rotation = 3

      val tmp = arr.take(rotation)

      for(i <- rotation to arr.length-1){
        arr(i-rotation) = arr(i)
      }

      val rotdArr = arr.take(arr.length - rotation) ++ tmp

      rotdArr.foreach(System.out.print)

    }

}
