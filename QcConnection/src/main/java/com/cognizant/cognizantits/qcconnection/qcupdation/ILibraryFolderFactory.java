package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{22638C3C-1998-4187-9426-805A7849F103}")
public abstract interface ILibraryFolderFactory
  extends IBaseFactoryEx
{
  @DISPID(9)
  @VTID(17)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject root();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ILibraryFolderFactory
 * JD-Core Version:    0.7.0.1
 */