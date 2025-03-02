/*
    Savagery, version [unreleased]. Copyright 2025 Jon Pretty, Propensive OÜ.

    The primary distribution site is: https://propensive.com/

    Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
    file except in compliance with the License. You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software distributed under the
    License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
    either express or implied. See the License for the specific language governing permissions
    and limitations under the License.
*/

package savagery

import anticipation.*
import prepositional.*
import proscenium.*

object Savagery:
  opaque type Degrees = Double
  opaque type SvgId = Text

  object SvgId:
    def apply(id: Text): SvgId = id

  object Degrees:
    def apply(degrees: Double): Degrees = degrees

    given encodable: Degrees is Encodable in Text = _.toString.tt

  extension (point: Point)
    @targetName("plus")
    infix def + (vector: Shift): Point = Point(point.x + vector.dx, point.y + vector.dy)

    @targetName("asVector")
    def `unary_~`: Shift = Shift(point.x, point.y)

  extension (vector: Shift)
    @targetName("plus2")
    infix def + (right: Shift): Shift = Shift(vector.dx + right.dx, vector.dy + right.dy)
