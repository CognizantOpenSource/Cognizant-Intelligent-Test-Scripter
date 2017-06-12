package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{75D8B306-2274-4D9B-9DF4-491A7D2A9B9A}")
public abstract interface ICustomizationRBTAnswer
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int id();
  
  @DISPID(2)
  @VTID(8)
  public abstract String answerText();
  
  @DISPID(2)
  @VTID(9)
  public abstract void answerText(String paramString);
  
  @DISPID(3)
  @VTID(10)
  public abstract int answerWeight();
  
  @DISPID(3)
  @VTID(11)
  public abstract void answerWeight(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationRBTAnswer
 * JD-Core Version:    0.7.0.1
 */