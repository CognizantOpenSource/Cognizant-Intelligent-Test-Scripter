package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{ACA08EA6-0781-4D21-95F9-4438BED9E0DA}")
public abstract interface ILibraryFolder
  extends IBaseFieldExMail
{
  @DISPID(15)
  @VTID(24)
  public abstract String name();
  
  @DISPID(15)
  @VTID(25)
  public abstract void name(String paramString);
  
  @DISPID(16)
  @VTID(26)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject libraryFactory();
  
  @DISPID(17)
  @VTID(27)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject libraryFolderFactory();
  
  @DISPID(18)
  @VTID(28)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject parent();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ILibraryFolder
 * JD-Core Version:    0.7.0.1
 */