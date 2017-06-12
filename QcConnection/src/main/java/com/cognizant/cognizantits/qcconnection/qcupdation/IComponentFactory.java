package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.Holder;
import com4j.IID;
import com4j.VTID;

@IID("{A4CEDAE3-5E32-43FC-9D39-FDA737799A1E}")
public abstract interface IComponentFactory
  extends IBaseFactory
{
  @DISPID(21)
  @VTID(17)
  public abstract boolean isComponentNameValid(String paramString, Holder<String> paramHolder);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IComponentFactory
 * JD-Core Version:    0.7.0.1
 */