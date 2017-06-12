package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Date;

@IID("{A9777EFF-7D62-4865-ADF6-1F1464A25E39}")
public abstract interface ILibrary
  extends IBaseFieldExMail
{
  @DISPID(15)
  @VTID(24)
  public abstract int libType();
  
  @DISPID(16)
  @VTID(25)
  public abstract String name();
  
  @DISPID(16)
  @VTID(26)
  public abstract void name(String paramString);
  
  @DISPID(17)
  @VTID(27)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject parent();
  
  @DISPID(18)
  @VTID(28)
  public abstract String creatorUser();
  
  @DISPID(18)
  @VTID(29)
  public abstract void creatorUser(String paramString);
  
  @DISPID(19)
  @VTID(30)
  public abstract Date creationDate();
  
  @DISPID(20)
  @VTID(31)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject libraryPartFactory();
  
  @DISPID(30)
  @VTID(32)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject baselineFactory();
  
  @DISPID(31)
  @VTID(33)
  public abstract int beginSync(ILibraryInfo paramILibraryInfo, int paramInt1, int paramInt2, IList paramIList);
  
  @DISPID(32)
  @VTID(34)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject libraryInfo();
  
  @DISPID(33)
  @VTID(35)
  public abstract ILibraryOperationResult createBaselineVerification();
  
  @DISPID(34)
  @VTID(36)
  public abstract ILibraryOperationResult syncLibrariesVerification(ILibraryInfo paramILibraryInfo, int paramInt1, int paramInt2);
  
  @DISPID(35)
  @VTID(37)
  public abstract int getLibraryTaskId();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ILibrary
 * JD-Core Version:    0.7.0.1
 */