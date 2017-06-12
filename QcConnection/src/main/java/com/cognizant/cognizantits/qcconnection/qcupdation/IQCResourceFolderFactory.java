package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{E6C516D5-501F-4C71-BFDB-18CDB7C33C5F}")
public abstract interface IQCResourceFolderFactory
  extends IBaseFactoryEx
{
  @DISPID(9)
  @VTID(17)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject root();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IQCResourceFolderFactory
 * JD-Core Version:    0.7.0.1
 */