package ProperConfigProgramm;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class ConfigParser {
    public Map<String,String> configParser(String path) throws ConfigException{
        if (path == null || path.isBlank()){
            throw new ConfigException("path does not exist");
        }
        Path configPath = Path.of(path);
        List<String> lines;
        try {
            lines = Files.readAllLines()
        }
    }
}
