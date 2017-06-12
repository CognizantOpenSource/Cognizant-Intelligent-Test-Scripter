package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{D641AF43-F4B6-4F9C-AC81-413557DC576C}")
public abstract interface ICustomizationRBTQuestion
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int id();
  
  @DISPID(2)
  @VTID(8)
  public abstract IList answers();
  
  @VTID(8)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object answers(int paramInt);
  
  @DISPID(3)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject answerByID(int paramInt);
  
  @DISPID(4)
  @VTID(10)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addAnswer();
  
  @DISPID(5)
  @VTID(11)
  public abstract void deleteAnswer(int paramInt);
  
  @DISPID(10)
  @VTID(12)
  public abstract String questionText();
  
  @DISPID(10)
  @VTID(13)
  public abstract void questionText(String paramString);
  
  @DISPID(11)
  @VTID(14)
  public abstract String questionDescription();
  
  @DISPID(11)
  @VTID(15)
  public abstract void questionDescription(String paramString);
  
  @DISPID(12)
  @VTID(16)
  public abstract int questionOrder();
  
  @DISPID(12)
  @VTID(17)
  public abstract void questionOrder(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationRBTQuestion
 * JD-Core Version:    0.7.0.1
 */