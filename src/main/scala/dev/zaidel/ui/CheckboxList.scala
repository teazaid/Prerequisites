package dev.zaidel.ui

import java.awt.GridLayout
import javax.swing.JCheckBox

class CheckboxList(prerequisites: List[JCheckBox]) extends AddHotKey {
  setLayout(new GridLayout(prerequisites.size, 1))

  prerequisites.zipWithIndex.take(reservedKeyEvents.size).foreach { case (p, index) =>
    add(p)
    val keyString = Character.toString(reservedKeyEvents(index).asInstanceOf[Char])
    p.setText(s"${keyString}. ${p.getText}")
    setKey(reservedKeyEvents(index), s"b_${keyString}", p)
  }

  prerequisites.headOption.foreach(_.requestFocus())

  def reset(): Unit = {
    prerequisites.foreach(_.setSelected(false))
    prerequisites.foreach(_.setVisible(true))
  }

  def hideUnChecked(): Unit = {
    prerequisites.collect {
      // hide non selected check items
      case checkBox if !checkBox.isSelected => checkBox.setVisible(false)
    }
  }
}
