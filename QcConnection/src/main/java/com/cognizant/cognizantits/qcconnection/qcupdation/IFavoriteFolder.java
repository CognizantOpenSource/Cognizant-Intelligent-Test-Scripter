package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{74974020-2EF5-4927-96CF-7F459F29BA3E}")
public abstract interface IFavoriteFolder
  extends IBaseField
{
  @DISPID(14)
  @VTID(20)
  public abstract String name();
  
  @DISPID(14)
  @VTID(21)
  public abstract void name(String paramString);
  
  @DISPID(15)
  @VTID(22)
  public abstract int parentId();
  
  @DISPID(15)
  @VTID(23)
  public abstract void parentId(int paramInt);
  
  @DISPID(16)
  @VTID(24)
  public abstract boolean _public();
  
  @DISPID(17)
  @VTID(25)
  public abstract String module();
  
  @DISPID(18)
  @VTID(26)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject favoriteFolderFactory();
  
  @DISPID(19)
  @VTID(27)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject favoriteFactory();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IFavoriteFolder
 * JD-Core Version:    0.7.0.1
 */