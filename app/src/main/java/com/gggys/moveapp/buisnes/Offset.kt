package com.gggys.moveapp.buisnes

import kotlin.math.ceil


fun offsetXGeneration(number: Int, width: Int, size: Int): Float{
    val step = (width/8).toFloat()


    if (number==1 || number%4==1) return step-size                             // 60f
    else if (number==2 || number%4==2) return step*3-size                  // 60f+2*(step)
    else if (number==3 || number%4==3) return step*5-size                       //  120f+3*(step)
   else return step*7-size                                                //180f+4*(step)
}

fun offsetYGeneration(number: Int, height: Int, size: Int): Float{
    val step = ((height*0.95)/8).toFloat()

    if (number in 1..4 ) return step/2-size                                           //60f
    else if(number>4 && number%4==0) return ceil(number.toFloat()/4)*step-size -step/2
    else return ceil(number.toFloat()/4)*step-size -step/2

}