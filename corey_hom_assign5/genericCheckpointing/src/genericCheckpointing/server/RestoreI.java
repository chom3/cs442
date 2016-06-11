package genericCheckpointing.server;

import genericCheckpointing.util.SerializableObject;
import java.util.Vector;

public interface RestoreI extends StoreRestoreI {
      Vector readObj(String wireFormat);
}