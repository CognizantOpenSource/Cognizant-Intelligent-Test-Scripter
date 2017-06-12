package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{10530C88-4197-428D-B4FB-4A39D2CCE526}")
public abstract interface ISupportAssetRelations
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject assetRelationFactory();
  
  @DISPID(2)
  @VTID(8)
  public abstract String download(String paramString, int paramInt);
  
  @DISPID(3)
  @VTID(9)
  public abstract IList using();
  
  @VTID(9)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object using(int paramInt);
  
  @DISPID(4)
  @VTID(10)
  public abstract IList usedBy();
  
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object usedBy(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISupportAssetRelations
 * JD-Core Version:    0.7.0.1
 */