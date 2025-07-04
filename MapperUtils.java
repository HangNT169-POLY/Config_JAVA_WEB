import org.modelmapper.ModelMapper;

public class MapperUtils {
    private static final ModelMapper modelMapper = new ModelMapper();

    /**
     * Map generic từ source sang class target mới
     */
    public static <S, T> T map(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }

    /**
     * Dùng cho update: copy field từ source sang object target đã tồn tại
     */
    public static <S, T> void mapToExisting(S source, T target) {
        modelMapper.map(source, target);
    }
}
