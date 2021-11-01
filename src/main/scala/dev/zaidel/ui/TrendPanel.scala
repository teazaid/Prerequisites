package dev.zaidel.ui

import java.awt.GridLayout
import javax.swing.{JPanel, JRadioButton}

class TrendPanel(trend: String) extends JPanel {
  import javax.swing.ButtonGroup

  setLayout(new GridLayout(1, 1))

  val group = new ButtonGroup()
  private val longButton = new JRadioButton(s"${trend} Лонг")
  private val shortButton = new JRadioButton(s"${trend} Шорт")
  private val rangeButton = new JRadioButton(s"${trend} Ренж")

  group.add(longButton)
  group.add(shortButton)
  group.add(rangeButton)

  add(longButton)
  add(shortButton)
  add(rangeButton)
}
