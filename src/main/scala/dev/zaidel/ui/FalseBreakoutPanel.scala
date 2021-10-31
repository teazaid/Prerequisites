package dev.zaidel.ui

import java.awt.event.KeyEvent
import java.awt.{Checkbox, GridLayout}

class FalseBreakoutPanel extends AddHotKey {
  setLayout(new GridLayout(12, 1))
  // ГТ и ЛТ совпадают
  private val checkbox = new Checkbox("1. Большое безоткатное движение")
  private val checkbox1 = new Checkbox("2. Закрылся далеко от уровня")
  private val checkbox2 = new Checkbox("3. Открылся > 50% ATR")
  private val checkbox3 = new Checkbox("4. Подход на паранормальном баре")
  private val checkbox4 = new Checkbox("5. Дистрибуция")
  private val checkbox5 = new Checkbox("6. Экстремум")
  private val checkbox6 = new Checkbox("7. Дальний ретест")
  private val checkbox7 = new Checkbox("8. Зона зараженности")
  private val checkbox8 = new Checkbox("9. Выравнивание")

  add(checkbox)
  add(checkbox1)
  add(checkbox2)
  add(checkbox3)
  add(checkbox4)
  add(checkbox5)
  add(checkbox6)
  add(checkbox7)
  add(checkbox8)

  setKey(KeyEvent.VK_1, "b_1", checkbox)
  setKey(KeyEvent.VK_2, "b_2", checkbox1)
  setKey(KeyEvent.VK_3, "b_3", checkbox2)
  setKey(KeyEvent.VK_4, "b_4", checkbox3)
  setKey(KeyEvent.VK_5, "b_5", checkbox4)
  setKey(KeyEvent.VK_6, "b_6", checkbox5)
  setKey(KeyEvent.VK_7, "b_7", checkbox6)
  setKey(KeyEvent.VK_8, "b_8", checkbox7)
  setKey(KeyEvent.VK_9, "b_9", checkbox8)

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
  }
}
