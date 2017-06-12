package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{D2FA8791-3A81-4D03-95CA-74EF6E059C4F}")
public abstract interface IComFrec
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void open(String paramString);
  
  @DISPID(2)
  @VTID(8)
  public abstract void writeRecord();
  
  @DISPID(3)
  @VTID(9)
  public abstract boolean readRecord();
  
  @DISPID(4)
  @VTID(10)
  public abstract String recordString();
  
  @DISPID(5)
  @VTID(11)
  public abstract String buffer();
  
  @DISPID(6)
  @VTID(12)
  public abstract String value(String paramString);
  
  @DISPID(6)
  @VTID(13)
  public abstract void value(String paramString1, String paramString2);
  
  @DISPID(7)
  @VTID(14)
  public abstract void addItem(String paramString1, String paramString2);
  
  @DISPID(8)
  @VTID(15)
  public abstract String valuePos(int paramInt);
  
  @DISPID(8)
  @VTID(16)
  public abstract void valuePos(int paramInt, String paramString);
  
  @DISPID(9)
  @VTID(17)
  public abstract boolean isAttribute(String paramString);
  
  @DISPID(10)
  @VTID(18)
  public abstract int numberOfAttributes();
  
  @DISPID(11)
  @VTID(19)
  public abstract String attributeName(int paramInt);
  
  @DISPID(11)
  @VTID(20)
  public abstract void attributeName(int paramInt, String paramString);
  
  @DISPID(12)
  @VTID(21)
  public abstract int attributePosition(String paramString);
  
  @DISPID(13)
  @VTID(22)
  public abstract void removeItem(String paramString);
  
  @DISPID(14)
  @VTID(23)
  public abstract void removeItemPos(int paramInt);
  
  @DISPID(15)
  @VTID(24)
  public abstract void clearItemList();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IComFrec
 * JD-Core Version:    0.7.0.1
 */