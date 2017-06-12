package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.VTID;

@IID("{97C351C8-CB1A-44C3-BC54-54D6FFB2AD6C}")
public abstract interface _ISubjectNode3
  extends Com4jObject
{
  @VTID(3)
  public abstract void undo();
  
  @VTID(4)
  public abstract boolean modified();
  
  @VTID(5)
  public abstract boolean autoUnlock();
  
  @VTID(6)
  public abstract void autoUnlock(boolean paramBoolean);
  
  @VTID(7)
  public abstract void post(@Optional @DefaultValue("-1") boolean paramBoolean);
  
  @VTID(8)
  public abstract boolean isFieldModified(String paramString, @Optional Object paramObject);
  
  @VTID(9)
  public abstract void undoField(String paramString);
  
  @VTID(10)
  public abstract boolean verifyPutFieldWithErrorOnFail(String paramString, @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @VTID(11)
  public abstract ISysTreeNode addNode(String paramString1, String paramString2, int paramInt);
  
  @VTID(12)
  public abstract IList findChildrenExact(String paramString1, @Optional @DefaultValue("0") boolean paramBoolean, @Optional @DefaultValue("") String paramString2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation._ISubjectNode3
 * JD-Core Version:    0.7.0.1
 */