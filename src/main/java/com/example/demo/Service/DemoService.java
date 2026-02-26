package com.example.demo.Service;
import com.example.demo.entity.Demo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService implements IDemoService {

    private final List<Demo> demoList = new ArrayList<>();

    public DemoService() {
        demoList.add(new Demo("Vinh", "13", 18L));
        demoList.add(new Demo("Vinh", "18", 20L));
        demoList.add(new Demo("Vinh", "12", 22L));
    }

    @Override
    public List<Demo> getAll() {
        return demoList;
    }

    @Override
    public Demo getById(Long id) {
        return demoList.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Demo demo) {
        demo.setId((long) (demoList.size() + 1));
        demoList.add(demo);
    }

    @Override
    public void delete(Long id) {
        demoList.removeIf(d -> d.getId().equals(id));
    }

    @Override
    public void update(Demo demo) {
        for (int i = 0; i < demoList.size(); i++) {
            if (demoList.get(i).getId().equals(demo.getId())) {
                demoList.set(i, demo);
                break;
            }
        }
    }
}
