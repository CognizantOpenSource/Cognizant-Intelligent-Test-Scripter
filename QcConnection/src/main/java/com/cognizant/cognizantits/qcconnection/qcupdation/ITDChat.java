package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{D323F3D1-837E-4C0F-9ACB-7CBCDDA557DC}")
public abstract interface ITDChat
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String connect(String paramString);
  
  @DISPID(2)
  @VTID(8)
  public abstract void disconnect();
  
  @DISPID(3)
  @VTID(9)
  public abstract String putMessage(String paramString);
  
  @DISPID(4)
  @VTID(10)
  public abstract String chatData(boolean paramBoolean);
  
  @DISPID(5)
  @VTID(11)
  public abstract void changeChat(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITDChat
 * JD-Core Version:    0.7.0.1
 */