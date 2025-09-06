# devops-with-kubernetes-2025

Repository for exercises of DevOps With Kubernetes 2025 course: https://courses.mooc.fi/org/uh-cs/courses/devops-with-kubernetes

## Exercises

### Chapter 1

- [1.1](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/1.1/log_output/log-output)
- [1.2](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/1.2/the_project)
- [1.3](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/1.3/log_output/log-output)
- [1.4](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/1.4/the_project)
- [1.5](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/1.5/the_project)
- [1.6](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/1.6/the_project)
- [1.7](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/1.7/log_output)
- [1.8](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/1.8/the_project)
- [1.9](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/1.9/log_output)
- [1.10](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/1.10/log_output/log-output-app)
- [1.11](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/1.11/log_output)
- [1.12](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/1.12/the_project)
- [1.13](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/1.13/the_project)

### Chapter 2

- [2.1](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/2.1/log_output)
- [2.2](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/2.2/the_project)
- [2.3](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/2.3/log_output)
- [2.4](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/2.4/the_project)
- [2.5](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/2.5/log_output)
- [2.6](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/2.6/the_project)
- [2.7](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/2.7/log_output)
- [2.8](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/2.8/the_project)
- [2.9] SKIPPED!
- [2.10](https://github.com/MiguelSombrero/devops-with-kubernetes-2025/tree/2.10/the_project)

## Notes

### Create k3d cluster from scratch

Create cluster with 2 agents and port 8081 open from the cluster:

```bash
k3d cluster create --port 8082:30080@agent:0 -p 8081:80@loadbalancer --agents 2
```

Install [kube-prometheus-stack](https://artifacthub.io/packages/helm/prometheus-community/kube-prometheus-stack) to cluster:

```bash
kubectl create namespace prometheus
```

```bash
helm install prometheus-community/kube-prometheus-stack --generate-name --namespace prometheus
```

Install Loki to cluster (deprecated, old version):

```bash
kubectl create namespace loki-stack
```

```bash
helm upgrade --install loki --namespace=loki-stack grafana/loki-stack --set loki.image.tag=2.9.3
```

