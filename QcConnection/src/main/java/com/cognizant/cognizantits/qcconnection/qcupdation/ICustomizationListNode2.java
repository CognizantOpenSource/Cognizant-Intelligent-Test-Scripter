package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{320F94F3-9268-4B87-B096-3C703B7FFE62}")
public abstract interface ICustomizationListNode2
  extends ICustomizationListNode
{
  @DISPID(15)
  @VTID(27)
  public abstract boolean isTemplate();
  
  @DISPID(16)
  @VTID(28)
  public abstract String type();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationListNode2
 * JD-Core Version:    0.7.0.1
 */