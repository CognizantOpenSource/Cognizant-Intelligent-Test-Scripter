package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{D7813508-1AF3-44EC-ACE2-FAE4BEF1E8BF}")
public abstract interface ILibraryPartFactory
  extends IBaseFactoryEx
{
  @DISPID(9)
  @VTID(17)
  public abstract boolean canModifyParts();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ILibraryPartFactory
 * JD-Core Version:    0.7.0.1
 */