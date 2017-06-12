package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{01A21FB9-74F1-4934-81F0-8C473F7A6E50}")
public abstract interface ICustomization2
  extends ICustomization
{
  @DISPID(15)
  @VTID(21)
  public abstract boolean isChanged();
  
  @DISPID(16)
  @VTID(22)
  public abstract void rollback();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomization2
 * JD-Core Version:    0.7.0.1
 */