package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.Optional;
import com4j.VTID;

@IID("{1F73BDFF-AC15-47FF-8264-88ADE733AAB7}")
public abstract interface IReqFactory2
  extends IReqFactory
{
  @DISPID(19)
  @VTID(27)
  public abstract IList getFilteredChildrenList(int paramInt, @Optional @DefaultValue("0") ITDFilter paramITDFilter);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IReqFactory2
 * JD-Core Version:    0.7.0.1
 */