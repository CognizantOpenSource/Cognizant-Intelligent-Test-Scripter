package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{23942689-4708-4AC4-8757-4E370C6A5CD8}")
public abstract interface IImportedLibrary
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject createdFromInfo();
  
  @DISPID(2)
  @VTID(8)
  public abstract int beginImport();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IImportedLibrary
 * JD-Core Version:    0.7.0.1
 */