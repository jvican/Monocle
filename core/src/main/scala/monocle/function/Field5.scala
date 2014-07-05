package monocle.function

import monocle._

trait Field5[S, A] {

  @deprecated("Use fifth", since = "0.5.0")
  def _5: SimpleLens[S, A] = fifth

  /** Creates a Lens from S to it is fifth element */
  def fifth: SimpleLens[S, A]

}

object Field5 extends Field5Instances

trait Field5Instances {

  @deprecated("Use fifth", since = "0.5.0")
  def _5[S, A](implicit ev: Field5[S, A]): SimpleLens[S, A] = ev._5

  def fifth[S, A](implicit ev: Field5[S, A]): SimpleLens[S, A] = ev.fifth

  implicit def tuple5Field5[A1, A2, A3, A4, A5] = new Field5[(A1, A2, A3, A4, A5), A5] {
    def fifth = SimpleLens[(A1, A2, A3, A4, A5), A5](_._5, (t, a) => t.copy(_5 = a))
  }

  implicit def tuple6Field5[A1, A2, A3, A4, A5, A6] = new Field5[(A1, A2, A3, A4, A5, A6), A5] {
    def fifth = SimpleLens[(A1, A2, A3, A4, A5, A6), A5](_._5, (t, a) => t.copy(_5 = a))
  }

}
