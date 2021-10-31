package dev.zaidel.ui

import java.awt.event.KeyEvent
import java.awt.{Checkbox, GridLayout}

class BreakoutPanel extends AddHotKey {
  setLayout(new GridLayout(12, 1))
  // ГТ и ЛТ совпадают
  private val checkbox = new Checkbox("1. Поджатие")
  private val checkbox1 = new Checkbox("2. Закрытие вблизи уровня")
  private val checkbox2 = new Checkbox("3. Ближний ретест")
  private val checkbox3 = new Checkbox("4. Закрытие под high/low")
  private val checkbox4 = new Checkbox("5. После ЛП нет отката")
  private val checkbox5 = new Checkbox("6. Подход на маленьких барах")
  private val checkbox6 = new Checkbox("7. После резкого движения нет отката")
  private val checkbox7 = new Checkbox("8. Впереди пустота")
  private val checkbox8 = new Checkbox("9. Большая консолидация")
  private val checkbox9 = new Checkbox("Q. Запас хода")
  private val checkbox10 = new Checkbox("W. Прилепание")

  add(checkbox)
  add(checkbox1)
  add(checkbox2)
  add(checkbox3)
  add(checkbox4)
  add(checkbox5)
  add(checkbox6)
  add(checkbox7)
  add(checkbox8)
  add(checkbox9)
  add(checkbox10)

  setKey(KeyEvent.VK_1, "b_1", checkbox)
  setKey(KeyEvent.VK_2, "b_2", checkbox1)
  setKey(KeyEvent.VK_3, "b_3", checkbox2)
  setKey(KeyEvent.VK_4, "b_4", checkbox3)
  setKey(KeyEvent.VK_5, "b_5", checkbox4)
  setKey(KeyEvent.VK_6, "b_6", checkbox5)
  setKey(KeyEvent.VK_7, "b_7", checkbox6)
  setKey(KeyEvent.VK_8, "b_8", checkbox7)
  setKey(KeyEvent.VK_9, "b_9", checkbox8)
  setKey(KeyEvent.VK_Q, "b_10", checkbox9)
  setKey(KeyEvent.VK_W, "b_11", checkbox10)

  checkbox.requestFocus()


  def reset(): Unit = {
    checkbox.setState(false)
    checkbox1.setState(false)
    checkbox2.setState(false)
    checkbox3.setState(false)
    checkbox4.setState(false)
    checkbox5.setState(false)
    checkbox6.setState(false)
    checkbox7.setState(false)
    checkbox8.setState(false)
    checkbox9.setState(false)
    checkbox10.setState(false)
  }
}
