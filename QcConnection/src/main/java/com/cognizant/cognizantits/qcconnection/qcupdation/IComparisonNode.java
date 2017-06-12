package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{9538CA0B-94E0-4784-B021-25D9138A34CB}")
public abstract interface IComparisonNode
  extends IBaseFieldEx
{
  @DISPID(16)
  @VTID(23)
  public abstract boolean isLeftValue();
  
  @DISPID(17)
  @VTID(24)
  public abstract boolean isGhost();
  
  @DISPID(18)
  @VTID(25)
  public abstract int changeType();
  
  @DISPID(19)
  @VTID(26)
  public abstract String path();
  
  @DISPID(20)
  @VTID(27)
  public abstract int entityID();
  
  @DISPID(21)
  @VTID(28)
  public abstract String entityName();
  
  @DISPID(22)
  @VTID(29)
  public abstract String entityType();
  
  @DISPID(23)
  @VTID(30)
  public abstract IList children();
  
  @VTID(30)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object children(int paramInt);
  
  @DISPID(24)
  @VTID(31)
  public abstract IComparisonNode nextChange();
  
  @DISPID(25)
  @VTID(32)
  public abstract IComparisonNode prevChange();
  
  @DISPID(26)
  @VTID(33)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject entity();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IComparisonNode
 * JD-Core Version:    0.7.0.1
 */