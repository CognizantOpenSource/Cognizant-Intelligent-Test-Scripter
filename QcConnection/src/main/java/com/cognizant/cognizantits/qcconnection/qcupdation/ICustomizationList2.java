package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{508349C0-3B3B-408D-887F-2AD85FCAF3F7}")
public abstract interface ICustomizationList2
  extends ICustomizationList
{
  @DISPID(5)
  @VTID(12)
  public abstract boolean isTemplate();
  
  @DISPID(6)
  @VTID(13)
  public abstract String type();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationList2
 * JD-Core Version:    0.7.0.1
 */