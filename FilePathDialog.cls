VERSION 1.0 CLASS
BEGIN
  MultiUse = -1  'True
END
Attribute VB_Name = "FilePathDialog"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Option Explicit

' ファイル拡張子
Public Enum FILE_EXT
  ALL
  EXCEL_FILE
  XLSX_FILE
  XLSM_FILE
  CSV_FILE
  TXT_FILE
  LOG_FILE
End Enum

' ダイアログボックスのタイトル
Private title_ As String

' ファイルフィルタ
Private fileFilter_ As String

Public Function GetFilePath(ByRef file_path As String) As Boolean
  GetFilePath = False
  
  Dim buf As Variant
  buf = Application.GetOpenFilename(FileFilter:=fileFilter_, Title:=title_)
  
  If VarType(buf) = vbBoolean Then
    MsgBox "ファイルの選択をキャンセルしました。"
    Exit Function
  End If
  
  file_path = buf
  
  GetFilePath = True
End Function

Public Property Let Title(ByVal dialog_title As String)
  title_ = dialog_title
End Property

Public Property Let Extension(ByVal file_extension As FILE_EXT)
  Select Case file_extension
    Case FILE_EXT.ALL
      fileFilter_ = ""
      
    Case FILE_EXT.EXCEL_FILE
      fileFilter_ = "Excel File(*.xls*), *.xls*"
      
    Case FILE_EXT.XLSX_FILE
      fileFilter_ = "xlsx File(*.xlsx), *.xlsx"
      
    Case FILE_EXT.XLSM_FILE
      fileFilter_ = "xlsm File(*.xlsm), *.xlsm"
      
    Case FILE_EXT.CSV_FILE
      fileFilter_ = "csv File(*.csv), *.csv"
      
    Case FILE_EXT.TXT_FILE
      fileFilter_ = "txt File(*.txt), *.txt"
      
    Case FILE_EXT.LOG_FILE
      fileFilter_ = "log File(*.log), *.log"
      
  End Select
End Property
