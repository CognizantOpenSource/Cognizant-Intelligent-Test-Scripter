package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.Optional;
import com4j.VTID;

@IID("{FCA0B016-AC98-4E63-A7EE-34759BF8038C}")
public abstract interface ITDMailConditions
  extends IObjectLockingSupport
{
  @DISPID(4)
  @VTID(10)
  public abstract void load();
  
  @DISPID(5)
  @VTID(11)
  public abstract String condition(String paramString, boolean paramBoolean);
  
  @DISPID(5)
  @VTID(12)
  public abstract void condition(String paramString1, boolean paramBoolean, String paramString2);
  
  @DISPID(6)
  @VTID(13)
  public abstract void deleteCondition(String paramString, boolean paramBoolean);
  
  @DISPID(7)
  @VTID(14)
  public abstract void close(boolean paramBoolean);
  
  @DISPID(8)
  @VTID(15)
  public abstract IList itemList(@Optional @DefaultValue("0") boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITDMailConditions
 * JD-Core Version:    0.7.0.1
 */