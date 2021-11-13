package dev.zaidel.ui

import java.awt.{BorderLayout, GridLayout}
import java.math.RoundingMode
import java.text.DecimalFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.swing.JFormattedTextField.AbstractFormatterFactory
import javax.swing._
import javax.swing.text.InternationalFormatter

class DetailsFrame(selectedPrerequisites: List[String],
                   gt: String,
                   lt: String,
                   lvlType: String) extends JDialog {
  JFrame.setDefaultLookAndFeelDecorated(true)
  setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)

  val enterPrice = new JTextField("0.0")

  val atrLeft = new JTextField("0.0")

  val topPanel = new JPanel(new GridLayout(6, 2))
  topPanel.add(new JTextField(LocalDate.now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
  topPanel.add(new JTextField("Symbol"))
  topPanel.add(new JLabel(s" ${gt}"))
  topPanel.add(new JLabel(s"${lt}"))
  topPanel.add(new JLabel(" Уровень:"))
  topPanel.add(new JLabel(s"${lvlType} "))
  topPanel.add(new JLabel(" Направление:"))
  topPanel.add(new JComboBox[String](Array("Long", "Short")))
  topPanel.add(new JLabel(" ТВХ:"))
  topPanel.add(enterPrice)
  topPanel.add(new JLabel(" ATR до уровня:"))
  topPanel.add(atrLeft)

  val mainPanel = new JPanel(new BorderLayout())

  setTitle("Детали Входа")

  val tabbedPane = new JTabbedPane()
  tabbedPane.setEnabled(false)
  val prerequisitesPanel = new JPanel(new GridLayout(selectedPrerequisites.size, 1))
  selectedPrerequisites.foreach { p =>
    prerequisitesPanel.add(new JLabel(s"- ${p.drop(2)}"))
  }
  tabbedPane.addTab("Предпосылки", prerequisitesPanel)

  mainPanel.add(topPanel, BorderLayout.NORTH)
  mainPanel.add(tabbedPane, BorderLayout.CENTER)

  setModal(true)
  setAlwaysOnTop(true)
  setContentPane(mainPanel)

  setResizable(false)
  pack()

  setVisible(true)
}
